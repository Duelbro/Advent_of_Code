module Day9a where 

intInput :: IO [Int]
intInput = map parseInt . lines <$> getContents

parseInt :: String -> Int
parseInt string = 
  error ""

ints :: String -> [Int]
ints string = map read split

main = do
  pointList <- intInput
  print (sum pointList)
