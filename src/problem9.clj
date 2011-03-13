(ns problem9)
(defn pythogorean?
    "checks if pythogorean law is satisfied for the 3 variables"
    [a b c]
    (= (+ (* a a) (* b b)) (* c c)))
(println
    (loop [b 1]
    (def ans
        (loop [a (inc b)]
            (if (< (+ a b) 1000)
                (let [c (- 1000 (+ a b))]
                    (if (pythogorean? a b c)
                        (* a b c)
                        (recur (inc a)))))))
    (if (not (nil? ans))
        ans
        (recur (inc b)))))
