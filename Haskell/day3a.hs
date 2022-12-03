module Day3a where 
import Data.Char(isLower)

intInput :: IO [Int]
intInput = map parseInt . lines <$> getContents

parseInt :: String -> Int
parseInt string
  | isLower dupeC = (fromEnum dupeC) - 96
  | otherwise = (fromEnum dupeC) - 38
  where dupeC = findDupe (split string)

findDupe :: (String, String) -> Char
findDupe (s1, s2) = head [x | x <- s1, y <- s2, x == y]

split :: String -> (String, String)
split s = splitAt (((length s) + 1) `div` 2) s

main = do
  pointList <- intInput
  print (sum pointList)
