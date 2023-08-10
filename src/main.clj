(ns main
  (:require [clojure.test :refer [with-test is run-tests]]))

(with-test
  (defn p01 [l]
    (list (last l)))

  (is (= (p01 '(a b c d)) '(d)))
  (is (= (p01 '(a)) '(a))))

(with-test
  (defn p02 [l]
    (take-last 2 l))

  (is (=
       (p02 '(a b c d))
       '(c d)))
  (is (=
       (p02 '(a a))
       '(a a))))

(with-test
  (defn p03 [l n]
    (nth l (- n 1)))

  (is (= (p03 '(a b c d e) 3) 'c)))

(comment
  (main))

(defn main []
  (run-tests 'main))
