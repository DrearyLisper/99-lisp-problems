^{:nextjournal.clerk/visibility {:code :hide}}
(ns main
  (:require [clojure.test :refer [with-test is run-tests]])
  (:require [nextjournal.clerk :as clerk]))

^{:nextjournal.clerk/visibility {:code :hide :result :hide}}
(comment
  (clerk/serve! {:host "0.0.0.0" :watch-paths ["notebooks" "src"]}))

;; P01 (*) Find the last box of a list.

^{:nextjournal.clerk/visibility {:code :fold}}
(with-test
  (defn p01 [l]
    (list (last l)))

  (is (= (p01 '(a b c d)) '(d)))
  (is (= (p01 '(a)) '(a))))

(p01 '(a b c d))

;; P02 (*) Find the last but one box of a list.
^{:nextjournal.clerk/visibility {:code :fold}}
(with-test
  (defn p02 [l]
    (take-last 2 l))

  (is (=
       (p02 '(a b c d))
       '(c d)))
  (is (=
       (p02 '(a a))
       '(a a))))

(p02 '(a b c d e))

;; P03 (*) Find the K'th element of a list.
^{:nextjournal.clerk/visibility {:code :fold}}
(with-test
  (defn p03 [l n]
    (nth l (- n 1)))

  (is (= (p03 '(a b c d e) 3) 'c)))

(p03 '(a b c d e) 3)


;; P04 (*) Find the number of elements of a list.
^{:nextjournal.clerk/visibility {:code :fold}}
(with-test
  (defn p04 [l]
    (cond
      (empty? l) 0
      :else (+ 1 (p04 (rest l)))))
  (is (= (p04 '()) 0))
  (is (= (p04 '(a b c d e)) 5)))

(p04 '(a b c d e))

;; P05 (*) Reverse a list.
^{:nextjournal.clerk/visibility {:code :fold}}
(with-test
  (defn p05 [l]
    (letfn [(inner
              [a b]
              (let [a-head (first a)]
                (cond
                  (empty? a) b
                  :else (inner (rest a) (cons a-head b)))))]
      (inner l '())))
  (is (= (p05 '()) '()))
  (is (= (p05 '(a b c d e)) '(e d c b a))))

(p05 '(a b c d e))

^{:nextjournal.clerk/visibility {:code :hide}}
(defn main []
  (run-tests 'main))

;; ## Run all tests
(main)