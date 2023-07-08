import numpy as np
from masks import subtractor
import cv2
import time

# open the video
VIDEO = './data/videos/Ponte.mp4'

# list of machine learning algorithms
algorithms = ['KNN', 'GMG', 'CNT', 'MOG', 'MOG2']

# open the video
cap = cv2.VideoCapture(VIDEO)

# choose the algorithm
bg_subtractor = subtractor(algorithms[0])


def kernel(kernel_type):
    if kernel_type == 'dilation':
        kernel = cv2.getStructuringElement(cv2.MORPH_ELLIPSE, (3, 3))
    if kernel_type == 'opening':
        kernel = np.ones((3, 3), np.uint8)
    if kernel_type == 'closing':
        kernel = np.ones((3, 3), np.uint8)
    return kernel


def filter(image, filter):
    if filter == 'closing':
        return cv2.morphologyEx(image, cv2.MORPH_CLOSE, kernel('closing'), iterations=2)
    if filter == 'opening':
        return cv2.morphologyEx(image, cv2.MORPH_OPEN, kernel('opening'), iterations=2)
    if filter == 'dilation':
        return cv2.dilate(image, kernel('dilation'), iterations=2)
    if filter == 'combine':
        closing = cv2.morphologyEx(image, cv2.MORPH_CLOSE, kernel('closing'), iterations=2)
        opening = cv2.morphologyEx(closing, cv2.MORPH_OPEN, kernel('opening'), iterations=2)
        dilation = cv2.dilate(opening, kernel('dilation'), iterations=2)
        return dilation





while True:
    # read the video
    has_frame, frame = cap.read()

    # break when it ends
    if not has_frame:
        break

    # put two windows side by side
    frame = cv2.resize(frame, (0, 0), fx=0.5, fy=0.5)
    
    # apply all algorithms
    mask = bg_subtractor.apply(frame)
    mask_filter = filter(mask, 'comgine')

    # show the video
    cv2.imshow('mask', mask)
    cv2.imshow('mask_filter', mask_filter)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# close the window
cv2.destroyAllWindows()  