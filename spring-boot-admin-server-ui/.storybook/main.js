const { mergeConfig } = require('vite');
const path = require('path');

module.exports = {
  stories: [
    '../src/main/frontend/components/**/*.stories.mdx',
    '../src/main/frontend/components/**/*.stories.@(js|jsx|ts|tsx)',
  ],
  addons: [
    '@storybook/addon-links',
    '@storybook/addon-essentials',
    {
      name: '@storybook/addon-styling',
      options: {
        postcssLoaderOptions: {
          implementation: require('postcss'),
        },
      },
    },
  ],
  framework: '@storybook/vue3',
  core: {
    builder: '@storybook/builder-vite',
  },
  async viteFinal(config) {
    return mergeConfig(config, {
      resolve: {
        alias: {
          '@': path.resolve(__dirname, '../src/main/frontend/'),
        },
        extensions: ['.vue', '.js', '.json'],
      },
    });
  },
};
