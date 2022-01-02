(define list1 (list -3 -6 -1 9))
(define list2 (list -8 62 71 -9))
(define list3 (list 7 3 -21 79))
(define list4 (list -3 -6 -1 9 0 -71 56))
(define list5 (list -9 6 9 -2))
(define list6 (list 10 -4 2 -7 9 -5))
(define list7 (list 2 45 -79 -56 -2))
(define list8 (list 92 19993342 -968234932 59203 -923045))
(define list9 (list -23 -94 -42 8))
(define list10 (list -1 -99 -4 9 10 65))

(define (bubbleSort lst)       ;define function bubblesort 
  (cond ((null? (cdr lst)) lst)     
        ((< (car lst) (cadr lst))   ;if first element < the rest of the list
         (cons (car lst) (bubbleSort (cdr lst))))   ;pair (append) first element and recursive call to next element
        (else
         (cons (cadr lst) (bubbleSort (cons (car lst) (cddr lst)))))))  ;pair (append) the rest of the list and recursive call bubbleSort the first element and the rest of the elements


(define (bubbleSortHelper n lst)    
  (cond ((= n 1) (bubbleSort lst))        ;cond (if) length = 1, call bubbleSort giving the given list
        (else (bubbleSortHelper (- n 1) (bubbleSort lst)))))   ;else recursive call bubbleSortHelper given length-1 and run run the bubbleSort method 

(define (main lst) 
  (bubbleSortHelper (length lst) lst))      ;call bubbleSortHelper with length of the given list and the list

(main list1)
(main list2)
(main list3)
(main list4)
(main list5)
(main list6)
(main list7)
(main list8)
(main list9)
(main list10)

