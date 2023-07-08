import cv2
import sys

VIDEO = './data/video/Ponte.mp4'

algorithms = ['KNN', 'GMG', 'CNT', 'MOG', 'MOG2']

def Subtractor(algorithm):

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
    
    sys.exit(1)

cap = cv2.VideoCapture(VIDEO)
bg_subtractor = Subtractor(cap)

if __name__ == '__main__':
    while True:
        has_frame, frame = cap.read()

        if not has_frame:
            break
    
    


        cv2.imshow('frame', frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
        
cv2.destroyAllWindows()  
    
