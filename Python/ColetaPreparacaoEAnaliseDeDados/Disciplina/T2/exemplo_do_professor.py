from flask import Flask
import flask.scaffold
flask.helpers._endpoint_from_view_func = flask.scaffold._endpoint_from_view_func

from flask_restful import reqparse, abort, Api, Resource

app = Flask(__name__)
api = Api(app)

COUNTRIES = {
    1: {'name':'Brasil', 'population': 220000000},
    2: {'name':'Estados Unidos', 'population': 20000000},
    3: {'name':'Argentina', 'population': 6500000},
}


def abort_if_country_doesnt_exist(country_id):
    if country_id not in COUNTRIES:
        abort(404, message=f'Country {country_id} doesn\'t exist')

parser = reqparse.RequestParser()
parser.add_argument('population', type=int)
parser.add_argument('name')


# Todo
# shows a single Country and lets you delete a Country
class Country(Resource):
    def get(self, country_id):
        abort_if_country_doesnt_exist(country_id)
        return COUNTRIES[country_id]

    def delete(self, country_id):
        abort_if_country_doesnt_exist(country_id)
        del COUNTRIES[country_id]
        return '', 204

    def put(self, country_id):
        args = parser.parse_args()
        content = {'name': args['name'], 'population': args['population']}
        COUNTRIES[country_id] = content
        return content, 201


class CountryList(Resource):
    def get(self):
        return COUNTRIES

    def post(self):
        args = parser.parse_args()
        country_id = max(COUNTRIES.keys()) + 1
        COUNTRIES[country_id] = {'name': args['name'], 'population': args['population']}
        return COUNTRIES[country_id], 201

##
## Actually setup the Api resource routing here
##
api.add_resource(CountryList, '/country')
api.add_resource(Country, '/country/<int:country_id>')


if __name__ == '__main__':
    app.run(debug=True)