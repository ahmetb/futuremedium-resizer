# Author: Ahmet Alp Balkan

require 'rubygems'
require 'rake'

def java_files
  @java_files = Dir['src/**/**/**/**/**/*.java'].join(' ')
end

task :default => [:build]

task :build => :compile do
  puts 'Packaging JAR...'  
  sh "jar -cf futuremedium.common2.images.resizer.jar -C build ."
  sh "rm -rf build/"
  puts 'Done.'
end

task :compile do
  puts 'Compiling...'  
  sh "mkdir -p build/"
  sh "javac -d build -classpath . #{java_files}"
  puts 'Done.'
end

