module Day2a where 

intInput :: IO [Int]
intInput = map parseInt . lines <$> getContents

parseInt :: String -> Int
parseInt string = 
  case string of
    "B X" -> 1
    "C X" -> 2
    "A X" -> 3
    "A Y" -> 4
    "B Y" -> 5
    "C Y" -> 6
    "C Z" -> 7
    "A Z" -> 8
    "B Z" -> 9

main = do
  pointList <- intInput
  print (sum pointList)
