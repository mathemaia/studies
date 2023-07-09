###
# In case the algorithm bellow does not work, it will be necessary to install contrib dependence.
# pip install --user opencv-contrib-python
###


import cv2
import numpy as np


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
    
# function to create the kernels
def kernel(kernel_type):
    if kernel_type == 'dilation':
        kernel = cv2.getStructuringElement(cv2.MORPH_ELLIPSE, (3, 3))
    if kernel_type == 'opening':
        kernel = np.ones((3, 3), np.uint8)
    if kernel_type == 'closing':
        kernel = np.ones((3, 3), np.uint8)
    return kernel

# apply the kernel to create a filter
def filter(image, filter_type):
    if filter_type == 'closing':
        return cv2.morphologyEx(image, cv2.MORPH_CLOSE, kernel('closing'), iterations=2)
    if filter_type == 'opening':
        return cv2.morphologyEx(image, cv2.MORPH_OPEN, kernel('opening'), iterations=2)
    if filter_type == 'dilation':
        return cv2.dilate(image, kernel('dilation'), iterations=2)
    if filter_type == 'combine':
        closing = cv2.morphologyEx(image, cv2.MORPH_CLOSE, kernel('closing'), iterations=2)
        opening = cv2.morphologyEx(closing, cv2.MORPH_OPEN, kernel('opening'), iterations=2)
        dilation = cv2.dilate(opening, kernel('dilation'), iterations=2)
        return dilation

# calculate the centroid of the cars
def centroide(x, y, w, h):
    # x: position x of object
    # y: position y of object
    # w: object's width
    # h: object's height

    x1 = w // 2
    y1 = h // 2
    c_x = x + x1
    c_y = y + y1

    return c_x, c_y