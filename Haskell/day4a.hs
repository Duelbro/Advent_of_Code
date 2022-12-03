module Day4a where 

intInput :: IO [Int]
intInput = map parseInt . lines <$> getContents

parseInt :: String -> Int
parseInt string = 
  error ""

main = do
  pointList <- intInput
  print (sum pointList)
