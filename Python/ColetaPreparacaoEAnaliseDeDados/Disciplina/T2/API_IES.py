# Authors: Gabriela Dellamora, João Enrique Cairuga, Matheus Maia and Luize Iensse
# Version: 23.04.2023

import pandas as pd
from flask import Flask
import flask.scaffold
flask.helpers._endpoint_from_view_func = flask.scaffold._endpoint_from_view_func

from flask_restful import reqparse, abort, Api, Resource

app = Flask(__name__)
api = Api(app)

# Lê arquivo JSON
INSTITUICOES_ENSINO = pd.read_json("./data/Dados_IES_Sul_indexado.json").to_dict()
# O arquivo estava como DF, modifiquei pra json

# Error handler
def doesnt_exist(data_id):
    if data_id not in INSTITUICOES_ENSINO:
        abort(404, message=f'Data id {data_id} doesn\'t exist.')      
        

##########################################################
#######                   PARSER                   #######
##########################################################

parser = reqparse.RequestParser()
parser.add_argument('SG_UF_IES')
parser.add_argument('TP_ORGANIZACAO_ACADEMICA', type = int)
parser.add_argument('TP_CATEGORIA_ADMINISTRATIVA', type = int)
parser.add_argument('NO_IES')
parser.add_argument('SG_IES')
parser.add_argument('NU_CEP_IES', type = float)
parser.add_argument('QT_DOC_TOTAL', type = int)
parser.add_argument('QT_DOC_EX_FEMI', type = int)
parser.add_argument('QT_DOC_EX_MASC', type = int)

##########################################################
#######                   CLASSES                  #######
##########################################################

# Shows a single data and lets you delete a data
class Dataset(Resource):

    def get(self, data_id):
        doesnt_exist(data_id) # Handle error
        return INSTITUICOES_ENSINO[data_id]   
    
    def delete(self, data_id):
        doesnt_exist(data_id) # Handle error
        del INSTITUICOES_ENSINO[data_id]
        return (f'Data {data_id} deleted.', 204)


    def put(self, data_id):
        args = parser.parse_args()
        content = {
            'SG_UF_IES': args['SG_UF_IES'], 
            'TP_ORGANIZACAO_ACADEMICA': args['TP_ORGANIZACAO_ACADEMICA'],
            'TP_CATEGORIA_ADMINISTRATIVA': args['TP_CATEGORIA_ADMINISTRATIVA'], 
            'NO_IES': args['NO_IES'], 
            'SG_IES': args['SG_IES'], 
            'NU_CEP_IES': args['NU_CEP_IES'],
            'QT_DOC_TOTAL': args['QT_DOC_TOTAL'], 
            'QT_DOC_EX_FEMI': args['QT_DOC_EX_FEMI'], 
            'QT_DOC_EX_MASC': args['QT_DOC_EX_MASC']
            }
        INSTITUICOES_ENSINO[data_id] = content
        return (content, 201)
    
class DataList(Resource):

    def get(self):
        return INSTITUICOES_ENSINO

    def post(self):
        args = parser.parse_args()
        data_id = max(INSTITUICOES_ENSINO.keys()) + 1
        INSTITUICOES_ENSINO[data_id] = {
            'SG_UF_IES': args['SG_UF_IES'], 
            'TP_ORGANIZACAO_ACADEMICA': args['TP_ORGANIZACAO_ACADEMICA'],
            'TP_CATEGORIA_ADMINISTRATIVA': args['TP_CATEGORIA_ADMINISTRATIVA'], 
            'NO_IES': args['NO_IES'], 
            'SG_IES': args['SG_IES'], 
            'NU_CEP_IES': args['NU_CEP_IES'],
            'QT_DOC_TOTAL': args['QT_DOC_TOTAL'], 
            'QT_DOC_EX_FEMI': args['QT_DOC_EX_FEMI'], 
            'QT_DOC_EX_MASC': args['QT_DOC_EX_MASC']
            }
        return (INSTITUICOES_ENSINO[data_id], 201)


##########################################################
#######                    ROUTER                  #######
##########################################################
# Actually setup the Api resource routing here
api.add_resource(DataList, '/dataset')
#api.add_resource(DataList, '/')
api.add_resource(Dataset, '/dataset/<int:data_id>')

# Run app
if __name__ == '__main__':
    app.run(debug=True)