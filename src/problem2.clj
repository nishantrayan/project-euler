(ns problem2)
(def fib-sum
    (loop [a 1 b 2 sum 0]
        (if (> a 4000000)
            sum
            (recur b (+ a b)
                (+ sum
                    (if (= 0 (mod a 2)) a 0))))))
(println fib-sum)
