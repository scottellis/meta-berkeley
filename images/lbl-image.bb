SUMMARY = "A console development image for Lawrence Berkeley Labs"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit core-image

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    term-prompt \
    tzdata \
"

KERNEL_EXTRA_INSTALL = " \
    kernel-modules \
"

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    pkgconfig \
"

NODEJS = " \
    nodejs \
    nodejs-dev \
    nodejs-npm \
    nodejs-systemtap \
"

DEV_EXTRAS = " \
    libusb1 \
    libusb1-dev \
    ntp \
    ntp-tickadj \
"

FORTRAN_TOOLS = " \
    gfortran \
    gfortran-symlinks \
    libgfortran \
    libgfortran-dev \
"

EXTRA_TOOLS_INSTALL = " \
    bzip2 \
    devmem2 \
    ethtool \
    findutils \
    i2c-tools \
    iperf \
    htop \
    less \
    nano \
    netcat \
    perl-modules \
    procps \
    sysfsutils \
    tcpdump \
    unzip \
    wget \
    zip \
"

# waiting on decision before including
WEBSERVER = " \
    hiawatha \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${FORTRAN_TOOLS} \
    ${KERNEL_EXTRA_INSTALL} \
    ${NODEJS} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
"

export IMAGE_BASENAME = "lbl-image"

