(ns problem10)
(def limit 2000000)
(def primes (ref [2]))
(defn is-prime?
    "checks if a number is prime by iterating over all primes from 2 to sqrt(n) and looking for potential factors"
    [n]
    (let [limit (int (Math/ceil (Math/sqrt n))) primes-vector @primes count-primes (count primes-vector)]
        (loop [i 0]
            (if (>= i count-primes)
                true
                (let [p (nth primes-vector i)]
                    (if (> p limit)
                        true
                        (if (zero? (mod n p))
                            false
                            (recur (inc i)))))))))
(println (apply + 2
                (for [n (range 3 2000000)]
                        (if (is-prime? n)
                            (do
                                (dosync
                                    (alter primes #(conj % n)))
                                n)
                            0))))

