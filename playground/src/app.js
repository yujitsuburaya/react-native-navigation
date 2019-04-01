// @ts-check
const { Navigation } = require('react-native-navigation');
const { registerScreens } = require('./screens');
const { Platform } = require('react-native');
const { setDefaultOptions } = require('./commons/Options')
const testIDs = require('./testIDs');
const Screens = require('./screens/Screens');
const Color = require('./commons/Colors');

if (Platform.OS === 'android') {
  alert = (title) => {
    Navigation.showOverlay({
      component: {
        name: Screens.Alert,
        passProps: {
          title
        },
        options: {
          layout: {
            componentBackgroundColor: 'transparent'
          },
          overlay: {
            interceptTouchOutside: true
          }
        }
      }
    });
  };
}

function start() {
  registerScreens();
  Navigation.events().registerAppLaunchedListener(async () => {
    setDefaultOptions();

    Navigation.setRoot({
      root: {
        bottomTabs: {
          options: {
            statusBar: {
              drawBehind: true
            },
            _bottomTabs: {
              tabsAttachMode: 'onSwitchToTab'
            }
          },
          children: [
            {
              stack: {
                children: [
                  {
                    component: {
                      name: 'Layouts',
                      options: {
                        statusBar: {
                          backgroundColor: '#ff000040',
                          style: 'dark',
                        },
                        topBar: {
                          elevation: 0,
                          drawBehind: true,
                          background: {
                            color: 'transparent',
                          }
                        }
                      }
                    }
                  }
                ],
                options: {
                  statusBar: {
                    drawBehind: true
                  },
                  layout: {
                    backgroundColor: Color.background
                  },
                  bottomTab: {
                    text: 'Layouts',
                    icon: require('../img/layouts.png'),
                    testID: testIDs.LAYOUTS_TAB
                  }
                }
              }
            },
            {
              stack: {
                children: [
                  {
                    component: {
                      name: 'Options'
                    }
                  }
                ],
                options: {
                  statusBar: {
                    drawBehind: false
                  },
                  topBar: {
                    title: {
                      text: 'Default Title'
                    }
                  },
                  bottomTab: {
                    text: 'Options',
                    icon: require('../img/options.png'),
                    testID: testIDs.OPTIONS_TAB
                  }
                }
              }
            },
            // {
            //   component: {
            //     name: 'Navigation',
            //     options: {
            //       _statusBar: {
            //         drawBehind: true
            //       }
            //     }
            //   }
            // }
            {
              stack: {
                children: [
                  {
                    component: {
                      name: 'Navigation'
                    }
                  }
                ],
                options: {
                  statusBar: {
                    drawBehind: false
                  }
                }
              }
            }
          ]
        }
      }
    });
  });
}

module.exports = {
  start
};
