[�{���ت�]
�qNCHC���Ѫ���Ʈw�P�}���Ƥ��^���B�q�B��H����ơA�ഫ��sensorthing server�i�H�������ɮ׮榡�C

[�{���\��]
�^���B�q�B��H����ơA�ӧO�N�ഫ�᪺�C����Ʃ߰e��sensorthing server�C

[���满��]
1. �sĶ�{����nchctransform.jar��

2. ����nchctransform.jar�ɡG
�榡�Gjava -jar nchctransform.jar [MainClass] [SensorthingServerUrl] [Option] [DataType]
Option:
-U, To update observations.

DataType:
A - ���ݮ�H��(txt)
B - ���ݮ�H��(2018_csv)
C - �۰ʮ�H��(txt)
D - �B�q��(txt)
E - �B�q��(csv)
F - �Y�ɸ��(�۰ʮ�H��-��H�[�����)
G - �Y�ɸ��(���ݮ�H��-�{�b�Ѯ��[�����i)
H - �Y�ɸ��(�۰ʫB�q��-�B�q�[�����)

�d�ҡGjava -jar nchctransform.jar com.mitac.NchcTransform.main.TransformMain http://10.11.10.39/v1.0 -U A C:\user
�d�ҵ��G�G��s���v��ƪ�observations

�d�ҡGjava -jar nchctransform.jar com.mitac.NchcTransform.main.TransformMain http://10.11.10.39/v1.0 -U G
�d�ҵ��G�G��s�Y�ɸ�ƪ�observations