import cv2
from util import get_limits
from PIL import Image

yellow = [0, 255, 0]
cap = cv2.VideoCapture(0)
while True:
    # read the frames
    has_frame, frame = cap.read()

    # create more windows to visualize
    frame = cv2.resize(frame, (0,0), fx=0.5, fy=0.5)

    # turn the frame into hsv
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    # get the limits of the color
    lower_limit, upper_limit = get_limits(yellow)
    
    # apply a mask
    mask = cv2.inRange(hsv, lower_limit, upper_limit)
    mask_ = Image.fromarray(mask)

    # create and draw a boundbox
    boundbox = mask_.getbbox()
    if boundbox is not None:
        x1, y1, x2, y2 = boundbox
        cv2.rectangle(frame, (x1, y1), (x2, y2), (0, 255, 0), 5)

    # show the video
    cv2.imshow('original', frame)
    cv2.imshow('mask', mask)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cv2.destroyAllWindows()