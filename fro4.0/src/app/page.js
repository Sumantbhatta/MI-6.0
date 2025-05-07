'use client';
import React from 'react';
import Link from 'next/link';
import { FaGithub, FaTwitter, FaLinkedin, FaInstagram } from 'react-icons/fa6';
import HomePage from './HomePage';

export default function Home() {
  return (
    <div className="relative min-h-screen flex flex-col overflow-hidden">
      {/* Animated Background Elements */}
      <div className="fixed inset-0 pointer-events-none">
        <div className="absolute top-0 left-0 w-full h-full bg-gradient-to-br from-blue-50 via-white to-teal-50" />
        <div className="absolute top-0 right-0 w-96 h-96 bg-blue-200/20 rounded-full blur-3xl animate-pulse" />
        <div className="absolute bottom-0 left-0 w-96 h-96 bg-teal-200/20 rounded-full blur-3xl animate-pulse" style={{ animationDelay: '1s' }} />
        <div className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 w-[800px] h-[800px] bg-indigo-200/10 rounded-full blur-3xl animate-pulse" style={{ animationDelay: '2s' }} />
      </div>

      {/* Main Content Overlay */}
      <div className="relative z-10 flex-1 flex flex-col">
        {/* Homepage-only Navbar */}
        <nav className="w-full  bg-opacity-0 backdrop-blur-sm shadow-sm py-4 px-6 flex items-center justify-between  top-0 z-20 absolute left-0">
          <div className="flex items-center gap-2">
            {/*<div className="relative">*/}
            {/*  <div className="absolute inset-0 bg-[#ffbd2b] rounded-full blur-sm animate-pulse" />*/}
            {/*  <img src="/images/logo.png" alt="Company Logo" className="relative h-9 w-9 rounded-full object-cover" />*/}
            {/*</div>*/}
            <div className='w-7 h-7 flex gap-5 items-center '>
                <img src="/assets/yellowLogo.png" alt="logo" style={{ animationDuration: '4s' }} className='animate-spin'/>
            </div>
            <span className="ml-2 text-2xl font-bold bg-[#ffbd2b] bg-clip-text text-transparent tracking-tight">RealEstatePro</span>
          </div>
          <div className="flex gap-4">
            <a href="/login" className="px-5 py-2 rounded-full font-medium bg-[#ffbd2b] text-black hover:bg-amber-300 transition-all duration-300 shadow-md hover:shadow-lg">Login</a>
            <a href="/register" className="px-5 py-2 rounded-full font-medium bg-[#ffbd2b] text-black hover:bg-amber-300 transition-all duration-300 shadow-md hover:shadow-lg">Register</a>
          </div>
        </nav>
        <HomePage ></HomePage>
        {/* Hero Section */}
        <section className="relative flex flex-col-reverse md:flex-row items-center text-center md:text-left px-4 py-20 md:py-32 overflow-hidden bg-[url('/images/hero-image.png')] bg-cover bg-center">
          <div className="absolute inset-0 bg-gradient-to-r from-black/70 to-black/50" />
          <div className="relative z-10 max-w-[920px] mx-auto md:mx-0 md:mr-12 flex-1">
            <h1 className="text-4xl md:text-5xl font-extrabold text-white mb-6 drop-shadow-lg ml-10 animate-fade-in">
              Efficiently Manage Your Real Estate Machinery & Inventory
            </h1>
            <p className="text-lg md:text-2xl text-white/90 mb-8 ml-10 animate-fade-in" style={{ animationDelay: '0.2s' }}>
              Track assets, schedule maintenance, and optimize your operations from one powerful dashboard.
            </p>
            <Link href="/login" legacyBehavior>
              <a className="inline-block px-8 py-4 bg-[#ffbd2b] text-black hover:bg-amber-300 rounded-xl font-semibold transition-all duration-300 text-lg ml-10 hover:shadow-xl hover:scale-105 animate-fade-in" style={{ animationDelay: '0.4s' }}>
                Get Started
              </a>
            </Link>
          </div>
        </section>


        {/* Completed Projects Section */}
        <section className="py-20 bg-gradient-to-br from-blue-50 via-white to-teal-50">
          <div className="max-w-6xl mx-auto px-4">
            <h2 className="text-3xl md:text-4xl font-bold text-center bg-black bg-clip-text text-transparent mb-4">Completed Projects</h2>
            <p className="text-center text-slate-600 mb-12 text-lg max-w-2xl mx-auto">Discover our successful real estate management implementations</p>
            <div className="grid gap-8 md:grid-cols-3">
              {/* Project Cards */}
              {[
                {
                  image: "/images/project1.jpg",
                  title: "Commercial Complex Management",
                  description: "Successfully managed 50+ commercial properties with automated maintenance tracking",
                  metric: "100% Uptime"
                },
                {
                  image: "/images/project2.jpg",
                  title: "Residential Estate Solutions",
                  description: "Implemented comprehensive asset management for 200+ residential units",
                  metric: "95% Efficiency"
                },
                {
                  image: "/images/project3.jpg",
                  title: "Industrial Park Management",
                  description: "Streamlined operations for a 500-acre industrial facility",
                  metric: "90% Cost Reduction"
                }
              ].map((project, index) => (
                <div
                  key={index}
                  className="group bg-white rounded-2xl shadow-md overflow-hidden hover:shadow-xl transition-all duration-300 hover:-translate-y-1"
                >
                  <div className="relative">
                    <div className="absolute inset-0 bg-gradient-to-t from-black/50 to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-300" />
                    <img
                      src={project.image}
                      alt={project.title}
                      className="w-full h-48 object-cover group-hover:scale-105 transition-transform duration-300"
                    />
                  </div>
                  <div className="p-6">
                    <h3 className="text-xl font-semibold mb-2 text-slate-800 group-hover:text-teal-600 transition-colors duration-300">
                      {project.title}
                    </h3>
                    <p className="text-slate-600 mb-4">
                      {project.description}
                    </p>
                    <div className="flex items-center text-teal-600">
                      <span className="font-semibold">{project.metric}</span>
                    </div>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </section>

        {/* Footer */}
        <footer className="bg-gradient-to-br from-gray-900 to-gray-800 text-gray-300">
          <div className="max-w-7xl mx-auto px-4 py-12">
            <div className="grid grid-cols-1 md:grid-cols-4 gap-8">
              {/* Company Info */}
              <div className="space-y-4">
                <h3 className="text-white text-lg font-semibold">Company</h3>
                <p className="text-sm">
                  Building the future of technology with innovative solutions.
                </p>
                <div className="flex space-x-4">
                  {[
                    { icon: FaGithub, href: "https://github.com" },
                    { icon: FaTwitter, href: "https://twitter.com" },
                    { icon: FaLinkedin, href: "https://linkedin.com" },
                    { icon: FaInstagram, href: "https://instagram.com" }
                  ].map((social, index) => (
                    <Link
                      key={index}
                      href={social.href}
                      className="hover:text-white transition-colors duration-300 hover:scale-110"
                    >
                      <social.icon size={20} />
                    </Link>
                  ))}
                </div>
                <div className="mt-4 p-3 bg-gray-800/50 rounded-lg backdrop-blur-sm border border-gray-700/50">
                  <p className="text-sm text-gray-400">Total Visitors</p>
                  <p className="text-2xl font-bold bg-gradient-to-r from-teal-400 to-blue-400 bg-clip-text text-transparent">1,234,567</p>
                </div>
              </div>

              {/* Quick Links */}
              <div className="space-y-4">
                <h3 className="text-white text-lg font-semibold">Quick Links</h3>
                <ul className="space-y-2">
                  {[
                    { name: "About Us", href: "/about" },
                    { name: "Services", href: "/services" },
                    { name: "Products", href: "/products" },
                    { name: "Blog", href: "/blog" }
                  ].map((link, index) => (
                    <li key={index}>
                      <Link
                        href={link.href}
                        className="hover:text-white transition-colors duration-300 hover:translate-x-1 inline-block"
                      >
                        {link.name}
                      </Link>
                    </li>
                  ))}
                </ul>
              </div>

              {/* Resources */}
              <div className="space-y-4">
                <h3 className="text-white text-lg font-semibold">Resources</h3>
                <ul className="space-y-2">
                  {[
                    { name: "Documentation", href: "/documentation" },
                    { name: "Support", href: "/support" },
                    { name: "FAQ", href: "/faq" },
                    { name: "Contact", href: "/contact" }
                  ].map((link, index) => (
                    <li key={index}>
                      <Link
                        href={link.href}
                        className="hover:text-white transition-colors duration-300 hover:translate-x-1 inline-block"
                      >
                        {link.name}
                      </Link>
                    </li>
                  ))}
                </ul>
              </div>

              {/* Contact Info */}
              <div className="space-y-4">
                <h3 className="text-white text-lg font-semibold">Contact Us</h3>
                <ul className="space-y-2">
                  <li className="flex items-center gap-2">
                    <span className="w-1 h-1 bg-teal-400 rounded-full" />
                    123 Business Street
                  </li>
                  <li className="flex items-center gap-2">
                    <span className="w-1 h-1 bg-teal-400 rounded-full" />
                    City, State 12345
                  </li>
                  <li className="flex items-center gap-2">
                    <span className="w-1 h-1 bg-teal-400 rounded-full" />
                    Phone: (555) 123-4567
                  </li>
                  <li className="flex items-center gap-2">
                    <span className="w-1 h-1 bg-teal-400 rounded-full" />
                    Email: info@company.com
                  </li>
                </ul>
              </div>
            </div>

            {/* Bottom Bar */}
            <div className="border-t border-gray-800 mt-12 pt-8">
              <div className="flex flex-col md:flex-row justify-between items-center">
                <p className="text-sm">
                  © {new Date().getFullYear()} Your Company. All rights reserved.
                </p>
                <div className="flex space-x-6 mt-4 md:mt-0">
                  {[
                    { name: "Privacy Policy", href: "/privacy" },
                    { name: "Terms of Service", href: "/terms" },
                    { name: "Cookie Policy", href: "/cookies" }
                  ].map((link, index) => (
                    <Link
                      key={index}
                      href={link.href}
                      className="text-sm hover:text-white transition-colors duration-300"
                    >
                      {link.name}
                    </Link>
                  ))}
                </div>
              </div>
            </div>
          </div>
        </footer>
      </div>
    </div>
  );
}
