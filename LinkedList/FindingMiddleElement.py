# your task is to complete this function
# function should return index to the any valid peak element
def findMid(head):
    # Code here
    slow = head
    fast = head
    
    while fast is not None and fast.next is not None : 
        slow = slow.next
        fast = fast.next.next
    
    # if fast is not None : 
    #     return slow
    # else : 
    #     return slow.next
    return slow