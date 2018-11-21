from ThreadData import *
from HttpRequest import *
import time

def main():
    ht = HttpRequest()
    tData = ThreadData()
    for i in range(100):
        print('*' * 20+'  Sending Message  '+'*' * 20)
        r = ht.post_request(
            'api/message/',
            tData.data
        )
        time_sleep= random.randrange(0, 4)
        print ('Message #: %s\nWait: %ss' % (i+1, time_sleep))
        print(r)

        # Sleep messages randomly
        time.sleep(time_sleep)


main()