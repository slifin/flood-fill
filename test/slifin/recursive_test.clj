(ns slifin.recursive-test
  (:require [clojure.test :refer [deftest testing is]]
            [slifin.flood-fill-recursive :refer [flood-fill]]))


(deftest recursive-test
  (testing "Tests an example flood fill"
    (is
      (= [[\C \C \B]
          [\C \B \C]
          [\C \C \C]]
        (flood-fill [[\A \A \B]
                     [\A \B \A]
                     [\A \A \A]] 0 0 \C)))))