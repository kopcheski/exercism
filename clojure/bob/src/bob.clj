(ns bob)
(use 'clojure.string)

(declare shouting? question? shouting-question? all-upper-case? remove-non-alphabetic)

(defn response-for [s]
  (cond
    (blank? s) "Fine. Be that way!"
    (shouting-question? s) "Calm down, I know what I'm doing!"
    (shouting? s) "Whoa, chill out!"
    (question? s) "Sure."
    :else "Whatever."
    )
  )

(defn shouting?
  [message]
  (all-upper-case? message))

(defn shouting-question? [message]
  (and (question? message) (shouting? message))
  )

(defn question? [message]
  (ends-with? message "?")
  )

(defn remove-non-alphabetic [message]
  (filter #(Character/isLetter %) message)
  )

(defn all-upper-case? [message]
  (def only-letters (apply str (remove-non-alphabetic message)))
  (and (not (blank? only-letters)) (every? #(Character/isUpperCase %) only-letters)))
