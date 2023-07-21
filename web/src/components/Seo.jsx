import React from "react"
import { useSiteMetadata } from "../hooks/use-site-metadata"

export const SeoConfig = ({ title, description }) => {
  const { title: defaultTitle, description: defaultDescription, image, siteUrl } = useSiteMetadata()

  const seo = {
    title: title || defaultTitle,
    description: description || defaultDescription,
    image,
    siteUrl
  }

  return (
    <>
      <title>{seo.title}</title>
      <meta name="description" content={seo.description} />
      <meta name="image" content={seo.image} />
      <meta httpEquiv="Cache-control" content="public"/>
     </>
  )
}