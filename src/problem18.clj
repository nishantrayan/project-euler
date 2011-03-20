(ns problem18)
(def triangle "00 75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23")
(def matcher (re-matcher #"[0-9][0-9]" triangle))
(def triangle-number (map #(Integer/parseInt %) (take-while #(not (nil? %)) (repeatedly #(re-find matcher)))))
(def len (count triangle-number))
(def max-sum (int-array len))
(defn find-row
    "returns the row number in which the index is present"
    [index]
    (loop [n 1 crossed 0]
        (let [next-crossed (+ n crossed)]
            (if (>= next-crossed index)
                n
                (recur (inc n) next-crossed)))))
(assert (= 1 (find-row 1)))
(assert (= 2 (find-row 2)))
(assert (= 3 (find-row 6)))
(assert (= 4 (find-row 7)))
(defn find-max-sum
    "returns the max sum from the current pos"
    [index]
    (if (>= index len)
        0
        (if (not (zero? (nth max-sum index)))
            (nth max-sum index)
            (let [row (find-row index)
                col (- index (bit-shift-right (* (dec row) row) 1))
                left-index (+ index col (- row col))
                right-index (inc left-index)
                sum (+ (nth triangle-number index)
                    (max (find-max-sum left-index)
                        (find-max-sum right-index)))]
                (do
                    (aset max-sum index sum)
                    sum)))))
(println (find-max-sum 1))


