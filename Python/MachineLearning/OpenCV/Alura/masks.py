###
# In case the algorithm bellow does not work, it will be necessary to install contrib dependence.
# pip install --user opencv-contrib-python
###

import cv2

# function to choose the algorithm
def subtractor(algorithm):
    if algorithm == 'KNN':
        return cv2.createBackgroundSubtractorKNN()
    if algorithm == 'GMG':
        return cv2.bgsegm.createBackgroundSubtractorGMG()
    if algorithm == 'CNT':
        return cv2.bgsegm.createBackgroundSubtractorCNT()
    if algorithm == 'MOG':
        return cv2.bgsegm.createBackgroundSubtractorMOG()
    if algorithm == 'MOG2':
        return cv2.createBackgroundSubtractorMOG2()