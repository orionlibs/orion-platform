#!/usr/bin/env bash
set -euo pipefail
JAR="target/app.jar"
java -jar "$JAR" <<'EOF'
help
time
echo Hello
exit
EOF
