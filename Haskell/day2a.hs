module Day2a where 

intInput :: IO [Int]
intInput = map parseInt . lines <$> getContents

parseInt :: String -> Int
parseInt string = 
  case string of
    "B X" -> 1
    "C Y" -> 2
    "A Z" -> 3
    "A X" -> 4
    "B Y" -> 5
    "C Z" -> 6
    "C X" -> 7
    "A Y" -> 8
    "B Z" -> 9

main = do
  pointList <- intInput
  print (sum pointList)
