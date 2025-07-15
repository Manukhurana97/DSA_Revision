import queue
class MyStack:

    def __init__(self):
        self.q1 = queue.Queue()
        self.q2 = queue.Queue()
        

    def push(self, x: int) -> None:
        self.q2.put(x)

        while not self.q1.empty():
            self.q2.put(self.q1.get())
        
        while not self.q2.empty():
            self.q1.put(self.q2.get())
        

    def pop(self) -> int:
        if self.empty(): return 

        return self.q1.get()
        

    def top(self) -> int:
        if self.q1.empty(): return 

        top_element = self.q1.get()
        self.q2.put(top_element)

        while not self.q1.empty():
            self.q2.put(self.q1.get())

        self.q1, self.q2 = self.q2, self.q1
        
        return top_element
        

    def empty(self) -> bool:
        return self.q1.empty()