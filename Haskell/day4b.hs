module Day4b where 
import Data.List.Split(splitOn)

intInput :: IO [Int]
intInput = map (parseInt . splitThis) . lines <$> getContents

splitThis :: String -> [[String]]
splitThis s = map (splitOn "-")  (splitOn "," s)

parseInt :: [[String]] -> Int
parseInt [[b1,e1],[b2,e2]]
  | bn1 > en2  = 0
  | en1 < bn2  = 0
  | otherwise = 1
  where
    bn1 = read b1 :: Int
    en1 = read e1 :: Int
    bn2 = read b2 :: Int
    en2 = read e2 :: Int

main = do
  pointList <- intInput
  print (sum pointList)
