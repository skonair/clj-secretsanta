(ns clj-secretsanta.core-test
  (:require [clojure.test :refer :all]
            [clj-secretsanta.core :refer :all]))

(def req-people [
	{:vorname "Luke" :nachname "Skywalker"}
	{:vorname "Leia" :nachname "Skywalker"}
	{:vorname "Toula" :nachname "Portokalos"}
	{:vorname "Gus" :nachname "Portokalos"}
	{:vorname "Bruce" :nachname "Wayne"}
	{:vorname "Virgil" :nachname "Brigman"}
	{:vorname "Lindsey" :nachname "Brigman"}
	{:vorname "John" :nachname "Doe"}
	{:vorname "Jane" :nachname "Doe"}
	{:vorname "Bobba" :nachname "Fett"}
	{:vorname "Anakin" :nachname "Skywalker"}])

(def res-santa (list
	'({:vorname "Luke", :nachname "Skywalker"} {:vorname "Toula", :nachname "Portokalos"})
	'({:vorname "Toula", :nachname "Portokalos"} {:vorname "Leia", :nachname "Skywalker"})
	'({:vorname "Leia", :nachname "Skywalker"} {:vorname "Gus", :nachname "Portokalos"}) 
	'({:vorname "Gus", :nachname "Portokalos"} {:vorname "Bruce", :nachname "Wayne"}) 
	'({:vorname "Bruce", :nachname "Wayne"} {:vorname "Virgil", :nachname "Brigman"}) 
	'({:vorname "Virgil", :nachname "Brigman"} {:vorname "John", :nachname "Doe"}) 
	'({:vorname "John", :nachname "Doe"} {:vorname "Lindsey", :nachname "Brigman"}) 
	'({:vorname "Lindsey", :nachname "Brigman"} {:vorname "Jane", :nachname "Doe"}) 
	'({:vorname "Jane", :nachname "Doe"} {:vorname "Anakin", :nachname "Skywalker"}) 
	'({:vorname "Anakin", :nachname "Skywalker"} {:vorname "Bobba", :nachname "Fett"}) 
	'({:vorname "Bobba", :nachname "Fett"} {:vorname "Luke", :nachname "Skywalker"})))

(deftest secret-santa-test
  (testing "secret-santa with "
    (is (= res-santa (secret-santa req-people)))))
