(ns problem5)
(defn nearest-power-of
    "finds the nearest power of a number to a certain limit"
    [num limit]
    (loop [power 1]
        (let [next-power (* power num)]
            (if (> next-power limit)
                power
                    (recur next-power)))))
(println (loop [current 2 product 1]
    (if (> current 20)
        product
            (recur (inc current)
                (if (zero? (mod product current))
                    product
                        (* product (nearest-power-of current 20)))))))
