import queue
class MyQueue:

    def __init__(self):
        self.q1 = queue.LifoQueue()
        self.q2 = queue.LifoQueue()
        

    def push(self, x: int) -> None:
        while not self.q1.empty():
            self.q2.put(self.q1.get())

        self.q1.put(x)

        while not self.q2.empty():
            self.q1.put(self.q2.get())
        
        return

        
    def pop(self) -> int:
        if self.empty(): return None
 
        return self.q1.get()


    def peek(self) -> int:
        if self.empty(): return None
        
        return self.q1.queue[-1]
        

    def empty(self) -> bool:
        return self.q1.empty()
        