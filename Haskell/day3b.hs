module Day3b where 
import Data.Char(isLower)
import Data.List.Split(chunksOf)

intInput :: IO [Int]
intInput = map parseInt . (chunksOf 3) . lines <$> getContents

parseInt :: [String] -> Int
parseInt stringList
  | isLower dupeC = (fromEnum dupeC) - 96
  | otherwise = (fromEnum dupeC) - 38
  where dupeC = findDupe stringList

findDupe :: [String] -> Char
findDupe [s1, s2, s3] = head 
  [x | x <- s1, y <- s2, x == y, z <- s3, y == z]

split :: String -> (String, String)
split s = splitAt (((length s) + 1) `div` 2) s

main = do
  pointList <- intInput
  print (sum pointList)
