module Day1b where 

import Data.List.Split(splitOn)
import Data.List(sort)

intInput :: IO [Int]
intInput = map parseInt . lines <$> getContents

parseInt :: String -> Int
parseInt string = 
  if null string 
    then 0
    else read string

main = do
  inputList <- intInput
  let elvesRations = map sum (splitOn [0] inputList)
  print (sum (take 3 (reverse (sort elvesRations))))
