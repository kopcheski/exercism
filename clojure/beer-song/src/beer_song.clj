(ns beer-song
  (:require [clojure.string :as s]))

(defn bottles-expression [num]
  (cond
    (= num 0) "No more bottles"
    (= num 1) "1 bottle"
    (< num 0) (bottles-expression 99)
    :else (str num " bottles"))
  )

(defn take-n-expression [num]
  (cond
    (= num 1) "Take it down and pass it around"
    (= num 0) "Go to the store and buy some more"
    :else "Take one down and pass it around")
  )

(defn first-sentence [num]
  (def bottles-expr (bottles-expression num))
  (str bottles-expr " of beer on the wall, " (s/lower-case bottles-expr) " of beer.\n")
  )

(defn second-sentence [num]
  (def bottles-expr (bottles-expression (dec num)))
  (str (take-n-expression num) ", " (s/lower-case bottles-expr) " of beer on the wall.\n")
  )

(defn verse
  [num]
  (str (first-sentence num) (second-sentence num))
  )

(defn sing
  ([start]
   (sing start 0))
  ([start end]
   (s/join "\n" (map verse (range start (dec end) -1))))
  )