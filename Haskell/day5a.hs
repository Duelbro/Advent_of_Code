module Day5a where 

intInput :: IO [Int]
intInput = map parseInt . lines <$> getContents

takeStackDef :: Int -> [String] -> [String]
takeStackDef i (x:xs)
  |  

parseInt :: String -> Int
parseInt string = 
  error ""

main = do
  pointList <- intInput
  print (sum pointList)
