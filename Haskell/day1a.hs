module Day1a where 

import Data.List.Split(splitOn)

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
  print (maximum elvesRations)
