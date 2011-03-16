(ns problem14)
(def depth-map (ref (array-map)))
(defn find-depth
    "finds depth of the number by applying a function : n/2 [n is event] : 3n+1 [n is odd]"
    [n]
    (if (= n 1)
        1
        (let [depth-from-map (depth-map n)]
            (if (not (nil? depth-from-map))
                depth-from-map
                (let [next-n (if (even? n) (int (/ n 2)) (+ (* 3 n) 1))
                    depth-from-recur (inc (find-depth next-n))]
                    (dosync (alter depth-map #(assoc % n depth-from-recur)))
                    depth-from-recur)))))
(assert (= (find-depth 2) 2))
(assert (= 10 (find-depth 13)))
(println (find-depth 1000000))
(println (apply max
    (map #(find-depth %) (range 1 1000001))))
