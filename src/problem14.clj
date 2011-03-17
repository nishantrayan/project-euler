(ns problem14)
(def depth-map (ref (array-map)))
(defn find-depth
    "finds depth of the number by applying a function : n/2 [n is event] : 3n+1 [n is odd]"
    [n]
    (loop [current-n n depth-so-far 1]
            (if (= current-n 1)
                (do
                    (dosync (alter depth-map #(assoc % current-n depth-so-far)))
                    depth-so-far)
                (let [depth-in-map (depth-map current-n)]
                    (if (not (nil? depth-in-map))
                        depth-in-map
                        (let [next-n (if (even? current-n) (bit-shift-right current-n 1) (+ (* 3 current-n) 1))]
                            (recur next-n (inc depth-so-far))))))))
(println (inc
            (let [depth-list (map #(find-depth %) (range 1 1000001))]
                (.indexOf depth-list (reduce max depth-list)))))

