#!/bin/bash
# SDK Setup Script - Downloads and configures required Android SDK components

set -e

SDK_DIR="$HOME/.android-sdk"
ANDROID_SDK_ROOT="${ANDROID_SDK_ROOT:-$SDK_DIR}"
ANDROID_HOME="${ANDROID_HOME:-$SDK_DIR}"

echo "Setting up Android SDK in $SDK_DIR..."

# Create SDK directory
mkdir -p "$SDK_DIR"
cd "$SDK_DIR"

# Download command-line tools
if [ ! -d "cmdline-tools" ]; then
    echo "Downloading command-line tools..."
    CMDLINE_TOOLS_URL="https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip"
    curl -sL "$CMDLINE_TOOLS_URL" -o cmdline-tools.zip
    echo "Extracting command-line tools..."
    python3 -c "import zipfile; zipfile.ZipFile('cmdline-tools.zip').extractall('.')"
    rm cmdline-tools.zip
    mkdir -p cmdline-tools/latest
    mv cmdline-tools/* cmdline-tools/latest/ 2>/dev/null || true
    chmod +x cmdline-tools/latest/bin/* 2>/dev/null || true
fi

# Set environment variables
export ANDROID_SDK_ROOT="$SDK_DIR"
export ANDROID_HOME="$SDK_DIR"
export PATH="$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"

# Accept licenses and install components
echo "Accepting licenses and installing SDK components..."
yes | "$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager" --licenses > /dev/null 2>&1 || true

# Install required components
"$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager" \
    "platforms;android-34" \
    "build-tools;35.0.0" \
    "platform-tools"

echo "SDK setup complete!"
echo "ANDROID_HOME=$ANDROID_HOME"
echo "ANDROID_SDK_ROOT=$ANDROID_SDK_ROOT"

