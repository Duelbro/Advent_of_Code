module Day6a where 

intInput :: IO [Int]
intInput = map (parseInt 4) . lines <$> getContents

parseInt :: Int -> String -> Int
parseInt i string@(x:xs) 
  | length string < 4       = 0
  | unique ( take 4 string)  = i
  | otherwise             = parseInt (i + 1) xs

unique :: String -> Bool
unique s = length [x | x <- s, y <- s, x == y] == length s

main = do
  pointList <- intInput
  print (sum pointList)
