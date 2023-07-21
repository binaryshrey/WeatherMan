/**
 * @type {import('gatsby').GatsbyConfig}
 */
module.exports = {
  plugins: [{
      resolve: `gatsby-plugin-manifest`,
      options: {
        name: 'WeatherMan',
        short_name: 'WeatherMan',
        start_url: '/',
        background_color: '#000000',
        theme_color: '#ffffff',
        display: 'standalone',
        icon: './logo.svg',
      },
    },
    {
      resolve: 'gatsby-plugin-html-attributes',
      options: {
        lang: 'en'
      }
    },
    {
      resolve: 'gatsby-plugin-netlify',
    }
  ],
  siteMetadata: {
    title: "Pokedex",
    description: "WeatherMan • Stay ahead of the storm",
    image: `/logo.webp`,
    siteUrl: `https://weatherman-zenstudio.netlify.app/`,
  },
}
