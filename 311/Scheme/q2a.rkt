(define list1 (list "a" "b" "c" "d" "a" "c" "a" "a"))
(define list2 (list "c" "c" "b" "e" "e" "e" "e" "a"))
(define list3 (list "a" "a" "b" "b" "b" "c" "b" "a" "b" "e"))
(define list4 (list "e" "e" "e" "e" ))
(define list5 (list " "))
(define list6 (list "d" "a" "b" "d" "c" "c" "d" "e" "e"))
(define list7 (list "a" "b" "c" "e" ))
(define list8 (list 92 92 92 92 1))
(define list9 (list "a" "d" "e" 6 8 "e" "c" 3 6 291))
(define list10 (list 99 99 99 1 99 99 1))

(define (remove c lst)          ;define remove function that takes in a char and list
  (cond ((null? lst) '())       ;cond - equilevent to if: lst is null, return empty list
        ((equal? (car lst) c)   ;if c = first element of list; (or first available element)
         (remove c (cdr lst)))  ;recursive call remove c and move pointer to the next element
        (else                   ;else
         (cons (car lst) (remove c (cdr lst))))))  ;add to the list and recursive call remove c with the rest of the elements 



(remove "a" list1)
(remove "c" list2)
(remove "b" list3)
(remove "e" list4)
(remove " " list5)
(remove "d" list6)
(remove "e" list7)
(remove 92 list8)
(remove 6 list9)
(remove 99 list10)
