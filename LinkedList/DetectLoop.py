# Your task is to complete this function
# Functioon should return 1/0 or True/False
def detectLoop(head):
    # code here
    slow = head
    fast = head
    f=0
    while fast is not None  and slow is not None and fast.next is not None: 
        fast = fast.next.next
        slow = slow.next
        if slow == fast : 
            return 1
        
    return 0