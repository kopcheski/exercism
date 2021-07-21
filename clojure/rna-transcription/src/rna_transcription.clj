(ns rna-transcription
  (:require [clojure.string :as str]))

(defn to-rna [dna]
  (assert (boolean (str/blank? (str/replace dna #"[GCTA]+" ""))))
  (str/escape dna {\G "C" \C "G" \T "A" \A "U"})
  )
