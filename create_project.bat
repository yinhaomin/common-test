set root=dumper
set project=dumper-%1
set package=%1
echo create project %project% with package %package%
mkdir %project%
cd %project%
mkdir lib shell src
cd src
mkdir main test
cd test
mkdir java configure
cd java
mkdir com
cd com
mkdir baidu
cd baidu
mkdir %root%
cd %root%
mkdir %package%
cd ..\..\..\..\..
cd main
mkdir java conf
cd conf
mkdir dev online qa static sb
cd ..
cd java
mkdir com
cd com
mkdir baidu
cd baidu
mkdir %root%
cd %root%
mkdir %package%
echo create project %project% finished now
cd ..\..\..\..\..\..\..
chdir
