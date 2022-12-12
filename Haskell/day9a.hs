module Day9a where 

type Pair = (Int, Int)

intInput :: IO [Int]
intInput = map parseInt . lines <$> getContents

parseInt :: Pair -> Pair -> [Pair] -> String -> Int
parseInt string = 
  error ""

-- ints :: String -> [Int]
-- ints string = map read split

main = do
  pointList <- intInput
  print (sum pointList)
