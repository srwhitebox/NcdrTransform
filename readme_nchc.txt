[程式目的]
從NCHC提供的資料庫與開放資料中擷取雨量、氣象等資料，轉換成sensorthing server可以接受的檔案格式。

[程式功能]
擷取雨量、氣象等資料，個別將轉換後的每筆資料拋送至sensorthing server。

[執行說明]
1. 編譯程式為nchctransform.jar檔

2. 執行nchctransform.jar檔：
格式：java -jar nchctransform.jar [MainClass] [SensorthingServerUrl] [Option] [DataType]
Option:
-U, To update observations.

DataType:
A - 局屬氣象站(txt)
B - 局屬氣象站(2018_csv)
C - 自動氣象站(txt)
D - 雨量站(txt)
E - 雨量站(csv)
F - 即時資料(自動氣象站-氣象觀測資料)
G - 即時資料(局屬氣象站-現在天氣觀測報告)
H - 即時資料(自動雨量站-雨量觀測資料)

範例：java -jar nchctransform.jar com.mitac.NchcTransform.main.TransformMain http://10.11.10.39/v1.0 -U A C:\user
範例結果：更新歷史資料的observations

範例：java -jar nchctransform.jar com.mitac.NchcTransform.main.TransformMain http://10.11.10.39/v1.0 -U G
範例結果：更新即時資料的observations