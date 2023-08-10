(ns main
  (:require [clojure.test :refer [with-test is run-tests]]))

(with-test
  (defn p01 [l]
    (list (last l)))

  (is (= (p01 '(a b c d)) '(d)))
  (is (= (p01 '(a)) '(a))))

(defn main []
  (run-tests 'main))