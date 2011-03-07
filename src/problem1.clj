(ns problem1)
(def sum (loop [i 0 sum 0]
    (let [to-add (if (or (= (mod i 3) 0)
                        (= (mod i 5) 0)) i 0)]
    (if (>= i 1000)
        sum
        (recur (inc i) (+ sum to-add))))))
(println sum)
